#!/bin/bash

set -e

curl -w '\n' -X PUT "localhost:9200/users_3" -H 'Content-Type: application/json' -d @- <<REQUEST_BODY
{
  "settings": {
    "index": {
      "number_of_shards": 1,
      "number_of_replicas": 1
    }
  },
"mappings": {
    "properties": {
          "id": {"type": "integer"},
          "name": {"type": "text"},
          "website": {"type": "keyword"},
    }
  }
}
REQUEST_BODY
