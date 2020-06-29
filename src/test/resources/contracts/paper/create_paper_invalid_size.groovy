package paper

import org.springframework.cloud.contract.spec.Contract


 Contract.make {
//    inProgress()
     description "should create a blank paper quiz size must > 5"

     request {
         url "/papers"
         method POST()
         headers {
             contentType applicationJson()
         }
         body(
                 ["teacherId": "8jk4lk-0d9ie-74jk-89lt8ikdj-6h50o8ij",
                  "quizzes"  : [
                          ["quizId": "8jk4lk-0t9he-74jk-89lt8ikdj-6h50o8ij", "score": 20],
                          ["quizId": "8jk4lk-0t9he-74yk-89lt8ikdj-6h50o8ij", "score": 20],
                          ["quizId": "8jk4lk-0t9he-74uk-89lt8ikdj-6h50o8ij", "score": 20],
                          ["quizId": "8jk4lk-0t9he-74uk-89lt86kdj-6h50o8ij", "score": 20],
                  ]
                 ]

         )
         bodyMatchers {
             jsonPath('$.teacherId', byRegex('[a-zA-Z-0-9]{36}'))
             jsonPath('$.quizzes', byType {
                 maxOccurrence(4)
             })
             jsonPath("\$.['quizzes'].['quizId']", byRegex('[a-zA-Z-0-9]{36}'))
             jsonPath("\$.['quizzes'].['score']", byRegex('100|[1-9][0-9]|[1-9]'))
         }
     }

     response {
         status BAD_REQUEST()
     }
 }