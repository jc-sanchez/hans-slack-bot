# Hans Slack Bot
## Overview
Hans is a bot that allows users to search GitHub from slack.  This project was started to familiarize myself with the AWS Java SKD, AWS Lex, AWS DynamoDB and AWS Lambda.  I also utilize an [open source library](http://github-api.kohsuke.org/) to interact with GitHub.  While I was at it, I also messed around with AWS CodePipeline a little.  Since I initially started this project to try out different AWS service, I did not include any unit tests.  Now that I have more experiece with the SDK and services, I plan on adding tests.

## Demo
![Hans Demo](https://s3.amazonaws.com/randombucketforrandomthings/hans-demo.gif)

## TODO List
1. Add unit tests.
2. Allow users to save repositores.
3. Allow users to add tags to their saved searches.
4. Implement searches for other services.
5. Use CodePipeline to build a pipline that runs tests and deploys code in AWS.
