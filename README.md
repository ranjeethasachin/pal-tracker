# Pal Tracker

## Trigger Builds

curl -i https://pal-tracker-kranthi-ranjeetha.apps.evans.pal.pivotal.io/time-entries

curl -i -XPOST -H"Content-Type: application/json" https://pal-tracker-kranthi-ranjeetha.apps.evans.pal.pivotal.io/time-entries -d"{\"projectId\": 1, \"userId\": 2, \"date\": \"2019-01-01\", \"hours\": 8}"

pal-tracker-exhausted-cat.apps.evans.pal.pivotal.io