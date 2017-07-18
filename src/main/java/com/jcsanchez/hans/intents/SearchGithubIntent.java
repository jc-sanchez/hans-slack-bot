package com.jcsanchez.hans.intents;

import com.amazonaws.services.lexruntime.model.Button;
import com.amazonaws.services.lexruntime.model.GenericAttachment;
import com.amazonaws.services.lexruntime.model.ResponseCard;
import com.jcsanchez.hans.model.*;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jcsanchez.hans.HansBot.delegate;

public class SearchGithubIntent extends Intent {
    static final private int MAX_SEARCH = 50;
    static final private int PAGE_SIZE = 5;

    public LexResponse processRequest() {
        System.out.println("Processing SearchGithubIntent");

        if (this.request == null) {
            throw new IllegalStateException("Request has not been set");
        }

        String source = request.getInvocationSource();
        if ("DialogCodeHook".equals(source)) {
            String searchTerm = request.getCurrentIntent().getSlots().get("SearchTerm");
            if (searchTerm == null) {
                return delegate(request.getSessionAttributes(), request.getCurrentIntent().getSlots());
            }

            return getSearchResults();
        }

        // TODO
        System.out.println("Returning null");
        return null;
    }

    private LexResponse getSearchResults() {
        System.out.println("Requesting search items from GitHub.");

        String searchTerm = request.getCurrentIntent().getSlots().get("SearchTerm");

        PagedIterator<GHRepository> searchIterator = null;
        try {
            searchIterator = GitHub.connectAnonymously().searchRepositories()
                    .q(searchTerm).list().withPageSize(MAX_SEARCH).iterator();
        } catch (IOException e) {
            // TODO: Handle exception
            e.printStackTrace();
        }
        System.out.println("GitHub API returned successfully.");

        if (!searchIterator.hasNext()) {
            return noRepositoriesFound();
        }

        List<GHRepository> repositories = new ArrayList<>(MAX_SEARCH);

        int counter = 0;
        while (searchIterator.hasNext()) {
            GHRepository repo = searchIterator.next();
            repositories.add(repo);
            counter++;
            if (counter == MAX_SEARCH) {
                break;
            }
        }

        saveSearchResults(repositories);

        return createResponse(repositories.subList(0, PAGE_SIZE - 1));
    }

    private LexResponse noRepositoriesFound() {
        // TODO
        return null;
    }

    private LexResponse createResponse(List<GHRepository> repositories) {
        ResponseCard responseCard = new ResponseCard().withContentType("application/vnd.amazonaws.card.generic");
        responseCard.setGenericAttachments(new ArrayList<GenericAttachment>());


        for (GHRepository repo : repositories) {
            GenericAttachment attachment = new GenericAttachment()
                    .withAttachmentLinkUrl(repo.getHtmlUrl().toString())
                    .withTitle(repo.getFullName())
                    .withSubTitle(String.format("%1.80s", repo.getDescription()))
                    .withButtons(new Button().withText("Save Repository")
                                             .withValue(repo.getFullName()));

            responseCard.getGenericAttachments().add(attachment);
        }

        responseCard.getGenericAttachments().add(new GenericAttachment()
                .withTitle(" ")
                .withButtons(new Button().withText("Next").withValue("Next")));

        DialogAction dialogAction = new DialogAction()
                .withType(DialogActionType.ElicitSlot)
                .withIntentName(request.getCurrentIntent().getName())
                .withSlots(request.getCurrentIntent().getSlots())
                .withSlotToElicit("Repository")
                .withResponseCard(responseCard)
                .withMessage(new Message()
                        .withContentType(ContentType.PlainText)
                        .withContent("Here is what I found"));

        return new LexResponse()
                .withSessionAttributes(request.getSessionAttributes())
                .withDialogAction(dialogAction);
    }

    private void saveSearchResults(List<GHRepository> repositories) {
        // TODO: Implement
    }
}
