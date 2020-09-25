docker build -t shahankitjava/demo-ms1:latest -t shahankitjava/demo-ms1:$SHA .
docker push shahankitjava/demo-ms1:latest
docker push shahankitjava/demo-ms1:$SHA

kubectl apply -f k8s

kubectl set image deployment/helm-demo-ms1-deployment helm-demo-ms1-container=shahankitjava/demo-ms1:$SHA