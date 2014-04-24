package ggic

class IssueController {

    def githubIssueService

    def report() {
        Issue issue = new Issue(params)

        githubIssueService.createIssue(issue)

        flash.message = "Issue $issue.title created"

        redirect uri: '/'
    }
}
