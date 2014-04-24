package ggic


class Issue {

    String title
    String body

    static constraints = {
        body nullable: true
    }

    static mapWith = "none"

}
