<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Tado issue reporter</title>
    <style>
        button.report-issue {
            margin: 10rem;
        }
    </style>
</head>

<body>
<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg report-issue" data-toggle="modal" data-target="#myModal">
    report an issue
</button>

<g:if test="${flash.message}">
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        ${flash.message}
    </div>
</g:if>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <g:form role="form" controller="issue" action="report">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">report an issue</h4>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input type="text" class="form-control" id="title" name="title" placeholder="Title" required>
                    </div>

                    <div class="form-group">
                        <label for="body">Body</label>
                        <textarea class="form-control" id="body" name="body" rows="3" placeholder="leave a comment"></textarea>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">report!</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
                </div>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>
