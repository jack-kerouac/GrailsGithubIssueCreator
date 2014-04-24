package ggic

import static groovyx.net.http.ContentType.JSON

class GithubIssueService {

    public static final String GITHUB_API_BASEURL = "https://api.github.com"
    public static final String GITHUB_API_MIME_TYPE = 'application/vnd.github.v3+json'
    public static final String USER_AGENT = 'Tado experience day client'

    def grailsApplication

    void createIssue(Issue issue) {
        def github = grailsApplication.config.github

        String issuesUri = "$GITHUB_API_BASEURL/repos/${github.repository.owner}/${github.repository.name}/issues"

        withRest(uri: issuesUri) {
            // use v3 of Github API
            headers.Accept = GITHUB_API_MIME_TYPE
            headers.'User-Agent' = USER_AGENT

            // authenticate with HTTP Basic Auth
            // the following does not work since HTTPBuilder cannot be run in 'preemptive' mode
            // see more here: http://stackoverflow.com/questions/6588256/using-groovy-http-builder-in-preemptive-mode
            // auth.basic githubUser, githubPassword
            String encoded = "${github.user}:${github.password}".getBytes('iso-8859-1').encodeBase64()
            headers.Authorization = "Basic $encoded"

            def issueBody = [title: issue.title, body: issue.body]
            // TODO: custom exceptions? differentiate between errors?
            def response = post(body: issueBody, requestContentType: JSON)

            log.info("issue $response.data.number created!")
        }

    }

}
