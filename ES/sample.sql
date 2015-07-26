GET /megacorp/employee/_search
{
   
}

--sort
GET /megacorp/employee/_search?_source=age
{
    "sort": {
        "age": { 
            "order": "desc"     
        } 
    }
}

--query string
GET /megacorp/employee/_search?q=age:[40 TO *]
GET /megacorp/employee/_search?q=last_name:Smith&age:<30

GET /megacorp/employee/_search?sort=age:desc&mode=min


--query the mapping
GET /megacorp/_mapping/employee



PUT /megacorp/employee/1
{
    "first_name" : "John",
    "last_name" :  "Smith",
    "age" :        25,
    "about" :      "I love to go rock climbing",
    "interests": [ "sports", "music" ]
}

GET /megacorp/employee/4
--aggregate the max age
GET /megacorp/employee/_search?_source=age
{
    "aggs" : {
        "max_age" : {
            "max" : {
                "field" : "age"
                } 
        }
    }
}

--get the maxmuim age
GET /megacorp/employee/_search?sort=age:desc&size=1&_source=age

GET /megacorp/employee/_search?q=age:>30&q=last_name:Liu
GET /megacorp/employee/_search?q=last_name:Liu
POST /megacorp/_mapping/employee/4/_update


GET /megacorp/employee/_search?f=age:exists
GET /megacorp/employee/_search

DELETE  /megacorp/employee/AU7KCSDHPlMQtRQSSAF4
DELETE  /megacorp/employee/AU7KCb9UPlMQtRQSSAF5

POST /megacorp/employee/_update
{
     "doc" : {
      "age":50
   }
   
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

HEAD /megacorp/employee/5

GET /megacorp/employee/_search?q=age:<30&last_name:Liu
GET /megacorp/employee/4
GET /megacorp/employee/3?_source=age,about
GET /megacorp/employee/3/_source

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

--agg in agg
GET /megacorp/employee/_search
{
    "aggs" : {
        "all_interests" : {
            "terms" : { "field" : "interests" },
            "aggs" : {
                "avg_age" : {
                    "avg" : { "field" : "age" }
                }
            }
        }
    }
}

PUT /website/blog/123
{
  "title": "My first blog entry",
  "text":  "I am starting to get the hang of this...",
  "date":  "2014/01/02"
}
DELETE /website/blog/123

PUT /website/blog/123/_create
{ 
}

GET /website/blog/123

--partial update
POST /website/blog/123/_update
{
   "doc" : {
      "tags" : [ "testing" ],
      "views": 111
   }
}
--partial update with scripts
POST /website/blog/123/_update
{
   "script" : "ctx._source.tags+=new_tag",
   "params" : {
      "new_tag" : "search"
   }
}

--mget
GET /_mget
{
   "docs" : [
      {
         "_index" : "website",
         "_type" :  "blog",
         "_id" :    2
      },
      {
         "_index" : "website",
         "_type" :  "pageviews",
         "_id" :    1,
         "_source": "views"
      }
   ]
}

POST /_bulk
{ "delete": { "_index": "website", "_type": "blog", "_id": "123" }} 
{ "create": { "_index": "website", "_type": "blog", "_id": "123" }}
{ "title":    "My first blog post" }
{ "index":  { "_index": "website", "_type": "blog" }}
{ "title":    "My second blog post" }
{ "update": { "_index": "website", "_type": "blog", "_id": "123", "_retry_on_conflict" : 3} }
{ "doc" : {"title" : "My updated blog post"} }

GET /website/blog/_search

--check the cluster status
GET /_cluster/health

--version control sample
PUT /website/blog/1/_create
{
  "title": "My first blog entry",
  "text":  "Just trying this out..."
}
GET /website/blog/1
PUT /website/blog/1?version=1 
{
  "title": "My first blog entry",
  "text":  "Starting to get the hang of this..."
}
--throw a version conflict exception
PUT /website/blog/1?version=1 
{
  "title": "My first blog entry",
  "text":  "Starting to get the hang of this..."
}


--use a external version
PUT /website/blog/2?version=5&version_type=external
{
  "title": "My first external blog entry",
  "text":  "Starting to get the hang of this..."
}
PUT /website/blog/2?version=6&version_type=external
{
  "title": "My first external blog entry",
  "text":  "Starting to get the hang of this..."
}
GET /website/blog/2

GET /_analyze?analyzer=standard
{
    I-Am-happy, Fuck You.
}

--create a mapping
PUT /gb 
{
  "mappings": {
    "tweet" : {
      "properties" : {
        "tweet" : {
          "type" :    "string",
          "analyzer": "english"
        },
        "date" : {
          "type" :   "date"
        },
        "name" : {
          "type" :   "string"
        },
        "user_id" : {
          "type" :   "long"
        }
      }
    }
  }
}
--update a mapping
PUT /gb/_mapping/tweet
{
    "properties":{
        "tag":{
            "type" : "string",
            "index": "not_analyzed"
        }
    }
}

GET /gb/_mapping/tweet
--test the mapping
GET /gb/_analyze?field=tweet
{
    Black-cats
}

GET /gb/_analyze?field=tag
{Black-cats}

GET /test/type1/1

PUT /test/type1/1
{
    "counter" : 1,
    "tags" : ["red"]
}

POST /test/type1/1/_update 
{
    "script" : "ctx._source.name_of_new_field = value_of_new_field"
}

GET /test/type1/_search
PUT /test/type1/2
{
    "counter" : 2,
    "tags" : ["red"]
}
PUT /test/type1/3
{
    "counter" : 20,
    "tags" : ["red"]
}
POST /test/type1/1/_update
{
    "doc" : {
        "name" : "new_name"
    }
}
POST /test/type1/1/_update
{
    "doc" : {
        "name" : "hello new name"
    }
}




