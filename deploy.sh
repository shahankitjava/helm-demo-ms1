docker build -t shahankitturn/demo-ms1:latest -t shahankitturn/demo-ms1:$SHA .
docker push shahankitturn/demo-ms1:latest
docker push shahankitturn/demo-ms1:$SHA

kubectl apply -f k8s/helm-demo-ms1-service.yml
kubectl apply -f k8s/helm-demo-ms1-deployment.yml

kubectl set image deployment/helm-demo-ms1-deployment helm-demo-ms1-container=shahankitturn/demo-ms1:$SHA