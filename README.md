1. run in terminal: docker-compose up -d
2. to copy data from output folder in container run:
   1. docker cp <container name/id>:app/output/ <dest path on host machine>
3. run docker-compose down

output data will also be stored on named volume dockertest_test_output