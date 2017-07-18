package com.jcsanchez.hans;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.jcsanchez.hans.intents.Intent;
import com.jcsanchez.hans.intents.IntentFactory;
import com.jcsanchez.hans.model.*;

public class HansBot implements RequestHandler<LexRequest, LexResponse>{
    static LambdaLogger logger;

    @Override
    public LexResponse handleRequest(LexRequest request, Context context) {
        logger = context.getLogger();
        logger.log(String.format("event.bot.name=%s\n", request.getBot().getName()));

        try {
            return dispatch(request);
        } catch (Exception e) {
            e.printStackTrace();

            // TODO create error response
            return null;
        }
    }

    private LexResponse dispatch(LexRequest request)  {
        String intentName = request.getCurrentIntent().getName();
        String userId = request.getUserId();

        logger.log(String.format("dispatch userId=%s, intentName=%s\n", userId, intentName));

        Intent intent = IntentFactory.getIntent(intentName);
        return intent.withRequest(request).processRequest();
    }

    private Map<String, String> buildValidationResult(boolean isValid, String violatedSlot, String messageContent) {
        Map<String, String> result = new HashMap<>();

        result.put("isValid", Boolean.toString(isValid));
        result.put("violatedSlot", violatedSlot);
        result.put("message", messageContent);

        return result;
    }

    public static LexResponse elicitSlot(Map<String, String> sessionAttributes,
                                      String intentName,
                                      Map<String, String> slots,
                                      String slotToElicit,
                                      String message) {

        DialogAction dialogAction = new DialogAction()
                .withType(DialogActionType.ElicitSlot)
                .withIntentName(intentName)
                .withSlots(slots)
                .withSlotToElicit(slotToElicit)
                .withMessage(new Message()
                                .withContentType(ContentType.PlainText)
                                .withContent(message));

        return new LexResponse()
                .withSessionAttributes(sessionAttributes)
                .withDialogAction(dialogAction);
    }

    public static LexResponse delegate(Map<String, String> sessionAttributes, Map<String, String> slots) {
        DialogAction dialogAction = new DialogAction()
                .withType(DialogActionType.Delegate)
                .withSlots(slots);

        return new LexResponse()
                .withSessionAttributes(sessionAttributes)
                .withDialogAction(dialogAction);
    }

    public static LexResponse close(Map<String, String> sessionAttributes, String fulfillmentState, Message message) {
        DialogAction dialogAction = new DialogAction()
                .withType(DialogActionType.Close)
                .withFullfillmentState(FulfillmentState.fromValue(fulfillmentState))
                .withMessage(message);

        return new LexResponse()
                .withSessionAttributes(sessionAttributes)
                .withDialogAction(dialogAction);
    }
}
