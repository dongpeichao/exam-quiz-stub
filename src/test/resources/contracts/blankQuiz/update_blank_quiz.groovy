package blankQuiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
//    inProgress()
    description "should create a blank quiz"

    request {
        url  $(consumer("/quizzes/${regex('[a-zA-Z-0-9]{36}')}"), producer("/quizzes/" +'d18f752b-c34e-4be9-b7d1-766a618497f1'))
        method PUT()
        headers {
            contentType applicationJson()
        }
        body(
                teacherId: $(consumer(regex('[a-zA-Z0-9]{36}'))),
                question: $(consumer(regex('.{1,255}'))),
                score: $(consumer(regex('100|[1-9][0-9]|[1-9]'))),
                referenceAnswer: $(consumer(regex('.{1,4000}')))
        )
    }

    response {
        status NO_CONTENT()
    }
}