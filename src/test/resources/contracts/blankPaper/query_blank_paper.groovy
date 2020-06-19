package blankPaper

import org.springframework.cloud.contract.spec.Contract

Contract.make {
//    inProgress()
    description "should query a blank quiz"

    request {
        url $(consumer("/papers/${regex('[a-zA-Z-0-9]{36}')}"), producer("/papers/f6b5d026-b3c3-4515-a86b-10fec35092ea"))
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                $(
                        producer(paperId: regex('[a-zA-Z-0-9]{36}'),
                                teacherId: regex('[a-zA-Z-0-9]{36}'),
                                quizzes:
                                        [
                                                [
                                                        id: regex('[a-zA-Z-0-9]{36}'),
                                                        score : regex('100|[1-9][0-9]|[1-9]')
                                                ]
                                        ]
                        )
                )
        )
    }
}