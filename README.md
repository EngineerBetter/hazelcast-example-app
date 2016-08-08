# hazelcast-example-app

Used to demonstrate/validate write/read operations with a remote Hazelcast cluster

## Deployment

```
mvn clean package
cf push --no-start
cf set-env ADDRESSES <CSV addresses of Hazelcast nodes>
cf start hazelcast-example-app
```

## Usage

`$ curl -X PUT -d value http://hazelcast-example-app.bosh-lite.com/key`

`$ curl http://hazelcast-example-app.bosh-lite.com/key`

## Testing

### Unit

`mvn clean test`

### System

To test that you can connect to a remote cluster, you need to specify a CSV list of addresses:

```
ADDRESSES=localhost,127.0.0.1 \
mvn clean verify
```