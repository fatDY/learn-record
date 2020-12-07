# Docker配置

## docker

[Hub · DaoCloud](http://hub.daocloud.io/)

{
  "registry-mirrors": [
    "https://docker.mirrors.ustc.edu.cn"
  ],
  "insecure-registries": [],
  "debug": true,
  "experimental": false
}

## elasticsearch

### 安装

```
docker pull elasticsearch:6.5.4
```



### 配置网络环境

```
docker network create somenetwork
```

### 运行

```
$ docker run -d --name elasticsearch --net somenetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:6.5.4
```

docker run -d --name kibana --net somenetwork -p 5601:5601 kibana

```sh
docker run  -d --name kibana --net somenetwork --link elasticsearch:6.5.4  -p 5601:5601 kibana:6.5.4
```

### IK分词器

[Release v6.5.4 · medcl/elasticsearch-analysis-ik (github.com)](https://github.com/medcl/elasticsearch-analysis-ik/releases/tag/v6.5.4/elasticsearch-analysis-ik-6.5.4)

[elasticsearch-analysis-ik-6.5.4.zip (github.com)](https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.5.4/elasticsearch-analysis-ik-6.5.4.zip)

#### 安装指令 

./elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.5.4/elasticsearch-analysis-ik-6.5.4.zip

### KIBANA测试

POST _analyze 
{
  "analyzer": "ik_max_word",
  "text":"杜宇测试"
}

### 操作指南

```
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
```

```
POST _analyze 
{
  "analyzer": "ik_max_word",
  "text":"杜宇测试"
}
```

```
GET /megacorp/employee/_search
{
  "aggs": {
    "all_interests": {
      "terms": { "field": "interests" }
    }
  }
}
```

```
GET /megacorp/employee/_search
{
  "query": {
    "match_phrase": {
      "about": "rock climbing"
    }
  },
  "highlight": {
    "fields": {
      "about": {}
    }
  }
}
```

```
GET /megacorp/employee/_search
{
  "query": {
    "bool": {
      "must": [
        {"match": {
          "last_name": "Smith"
        }
        

​    }
  ],"filter": {"range": {
​    "age": {
​      "gt": 10
​    }
  }}
}

  }
}
```

```
PUT /megacorp/employee/_mapping
{
  "properties": {
    "first_name" : {"type": "text"},
    "last_name" :  {"type": "text"},
    "age" :        {"type": "long"},
    "about" :       {"type": "text"},
    "interests": {"type": "text","fielddata": true}
  }
}
```

```
PUT /megacorp/employee/1
{
    "first_name" : "John",
    "last_name" :  "Smith",
    "age" :        25,
    "about" :      "I love to go rock climbing",
    "interests": [ "sports", "music" ]
}
```

```
PUT /megacorp/employee/2
{
    "first_name" :  "Jane",
    "last_name" :   "Smith",
    "age" :         32,
    "about" :       "I like to collect rock albums",
    "interests":  [ "music" ]
}
```

```
PUT /megacorp/employee/3
{
    "first_name" :  "Douglas",
    "last_name" :   "Fir",
    "age" :         35,
    "about":        "I like to build cabinets",
    "interests":  [ "forestry" ]
}
```

