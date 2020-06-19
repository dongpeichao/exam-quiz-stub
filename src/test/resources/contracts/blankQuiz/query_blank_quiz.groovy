package blankQuiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
//    inProgress()
    description "should query a blank quiz"

    request {
        url $(consumer("/quizzes/${regex('[a-zA-Z-0-9]{36}')}"),producer("/quizzes/8e0ed598-40ff-4d72-8ebc-b4759edafa4c"))
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                $(
                        producer(
                                id: regex('[a-zA-Z-0-9]{36}'),
                                teacherId: regex('[a-zA-Z-0-9]{36}'),
                                question: regex('.{1,255}'),
                                score: regex('100|[1-9][0-9]|[1-9]'),
                                referenceAnswer: regex('.{1,4000}')
                        )
                )

        )
    }
}