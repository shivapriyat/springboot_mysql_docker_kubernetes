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

// RENAME helmscripts for code reference

mkdir helmscripts

cd helmscripts

helm create springbootmysqlhelm

tree springbootmysqlhelm

//COPY file values.yaml and templates/ entire folder from RENAMED folder and overwrite

cd springbootmysqlhelm

//
Add Ingress

helm repo add nginx-stable https://helm.nginx.com/stable

helm repo update


helm template springbootmysqlhelm

helm lint springbootmysqlhelm

helm install springbootmysqlhelmrelease springbootmysqlhelm

helm list -a


kubectl get secrets,pv,pvc,pods,svc,ingress                verify all running

kubectl logs spring-boot-deployment-77c56c659d-78hd6


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


helm delete springbootmysqlhelmrelease

docker rmi springboot-mysql-k8s:1