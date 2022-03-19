# maze
Simple maze solver

### SUBMITTING A REQUEST

Submit a maze to solve via command line (curl) or POSTMAN:

```
curl --request POST --url http://localhost:32708/api/maze --header 'Content-Type: text/plain' --data '#S#######
#   #   #
# ### # #
# #   # #
# # # ###
#   # # #
# ### # #
#   #   E
#########'
```

### DEPLOYMENT

**Deploy as a Container on [Rancher](https://rancherdesktop.io/) using *nerdctl*:**

- cd to base dir

- Build the container

  `nerdctl build -t dockerhansel/maze .`


- Run the container

    `nerdctl run -d -p 8081:8080 dockerhansel/maze`


- Test (using port 8081)

**Stop the container:**

`nerdctl ps` ## get the container id
    
`nerdctl stop [container id]`

**Deploy using *kubectl*:**

- cd to base/kubernetes folder

    `kubectl apply -f deployment.yaml -n default`


- Test (using port 32708).  _See curl command above as an example_.

**Undeploy using *kubectl*:**
    
`kubectl delete -f deployment.yaml -n default`