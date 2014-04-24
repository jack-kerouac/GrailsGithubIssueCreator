includeTargets << grailsScript("_GrailsBootstrap")

target(postIssue: "create an issue at Github!") {
    depends(configureProxy, packageApp, classpath, loadApp, configureApp)
    def service = appCtx.getBean('githubIssueService')

    service.createIssue('test title', 'test body')

    println "issue successfully created"
}


setDefaultTarget(postIssue)
