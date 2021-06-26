Spring boot mysql


minikube start


-----

If local mysql is running then execute below b4 proceeding
  sudo ln -s /etc/apparmor.d/usr.sbin.mysqld /etc/apparmor.d/disable/
sudo apparmor_parser -R /etc/apparmor.d/usr.sbin.mysqld
 
 -------

 eval $(minikube docker-env)


Verify updated K8s properties in application.proprties


mvn -U clean compile package


docker build -t springboot-mysql-k8s:1 .


docker image ls


kubectl apply -f k8sscripts/secrets.yaml


kubectl apply -f k8sscripts/pv.yaml


kubectl apply -f k8sscripts/pvc.yaml


kubectl apply -f k8sscripts/deployment-mysql.yaml


kubectl apply -f k8sscripts/service-mysql.yaml


kubectl apply -f k8sscripts/deployment-spring.yaml


kubectl apply -f k8sscripts/service-spring.yaml


kubectl apply -f k8sscripts/ingress.yaml


kubectl get secrets,pv,pvc,pods,svc,ingress                verify all running

kubectl logs spring-boot-deployment-84655686dc-p5pzv


minikube ip  > 192.168.49.2


sudo vi /etc/hosts ---> 192.168.49.2 human.com


final url= http://human.com/person


curl -X GET http://human.com/person


curl -X POST -H "Content-Type: application/json" --data '{"age": 90000,"firstName":"Ganesha", "lastName":"S"}' http://human.com/person


curl -X POST -H "Content-Type: application/json" --data '{"age": 100000,"firstName":"Shiva", "lastName":""}' http://human.com/person


curl -X PUT -H "Content-Type: application/json" --data '{"age": 100000,"firstName":"Shiva", "lastName":"S"}' http://human.com/person/2



curl -X POST -H "Content-Type: application/json" --data '{"age": 30,"firstName":"Shivapriya", "lastName":"t"}' http://human.com/person


curl -X DELETE http://human.com/person/3


CLEANUP


kubectl delete -f k8sscripts/pv.yaml


kubectl delete -f k8sscripts/pvc.yaml


kubectl delete -f k8sscripts/secrets.yaml


kubectl delete -f k8sscripts/deployment-mysql.yaml 


kubectl delete -f k8sscripts/service-mysql.yaml


kubectl delete -f k8sscripts/deployment-spring.yaml


kubectl delete -f k8sscripts/service-spring.yaml


kubectl delete -f k8sscripts/ingress.yaml


docker rmi springboot-mysql-k8s:1