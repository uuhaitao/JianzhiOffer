GET _search
{
   
}

PUT /megacorp/employee/1
{
    "first_name" : "John",
    "last_name" :  "Smith",
    "age" :        25,
    "about" :      "I love to go rock climbing",
    "interests": [ "sports", "music" ]
}

PUT /megacorp/employee/2
{
    "first_name" :  "Jane",
    "last_name" :   "Smith",
    "age" :         32,
    "about" :       "I like to collect rock albums",
    "interests":  [ "music" ]
}

PUT /megacorp/employee/3
{
    "first_name" :  "Douglas",
    "last_name" :   "Fir",
    "age" :         35,
    "about":        "I like to build cabinets",
    "interests":  [ "forestry" ]
}
PUT /megacorp/employee/4
{
    "first_name" :  "Haitao",
    "last_name" :   "Liu",
    "age" :         25,
    "about":        "I like to read books",
    "interests":  [ "reading" ]
}


GET /megacorp/employee/1
GET /megacorp/employee/3

GET /megacorp/_mapping/employee

GET /megacorp/employee/_search

GET /megacorp/employee/_search?q=last_name:Liu

--query match
GET /megacorp/employee/_search
{
    "query" : {
        "match" : {
            "last_name" : "Smith"
        }
    }
}

--query filter
GET /megacorp/employee/_search
{
    "query" : {
        "filtered" : {
            "filter" : {
                "range" : {
                    "age" : { "gt" : 25 } 
                }
            },
            "query" : {
                "match" : {
                    "last_name" : "smith" 
                }
            }
        }
    }
}

--query fulltext
GET /megacorp/employee/_search
{
    "query" : {
        "match" : {
            "about" : "read a book"
        }
    }
}

--query match_phrase
GET /megacorp/employee/_search
{
    "query" : {
        "match_phrase" : {
            "about" : "read a book"
        }
    }
}

--highlight
GET /megacorp/employee/_search
{
    "query" : {
        "match_phrase" : {
            "about" : "rock climbing"
        }
    },
    "highlight": {
        "fields" : {
            "about" : {}
        }
    }
}

--group
--aggregate
GET /megacorp/employee/_search
{
  "aggs": {
    "all_interests": {
      "terms": { "field": "interests" }
    }
  }
}


--query
--group
GET /megacorp/employee/_search
{
  "query": {
    "match": {
      "last_name": "smith"
    }
  },
  "aggs": {
    "all_interests": {
      "terms": {
        "field": "interests"
      }
    }
  }
}








































