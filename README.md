#  Simplifying Spring CronJobs with Kubernetes

## Overview

In a typical Spring Boot application, scheduled tasks are defined with the `@Scheduled` annotation. However, running multiple instances of the same app in a Kubernetes cluster can lead to duplicate executions. This can waste resources and even cause race conditions. 

In a Spring Boot app, @Scheduled is great for running tasks at fixed intervals. But as we scale, things get messy:
- **Multiple pods**: Each pod runs the same job, which can lead to duplicate work.
- **Heavy tasks**: A big job can slow down the whole app.
- **Scaling issues**: It's hard to manage when and where jobs run.

Using Kubernetes CronJobs and Spring Boot Project, we are able to control all our scheduling in an efficient way. Just pass command-line arguments for indicating which job is supposed to run, and we are good to go! Kubernetes will manage these jobs outside of our app pods, avoiding duplication issues and keeping everything running smoothly.

This project demonstrates how to deploy scheduled tasks in a Kubernetes environment using CronJobs. We are using two scheduled jobs:
1. **Notification Job**: Runs every 5 minutes.
2. **DataSync Job**: Runs every 10 minutes.

## Try It Out

#### 1: Clone the Repository
```bash
git clone git clone https://github.com/yusuf-aziz/spring-kubernetes-cronjobs.git
```

#### 2: Navigate to the cloned repository
```bash
cd spring-kubernetes-cronjobs
```

#### 3: Run mvn clean install
```bash
mvn clean install
```

#### 4: Start the minikube
```bash
minikube start
```

#### 5: Build Docker Image in Minikube
Minikube uses its own Docker daemon, so set your shell to point to it:

```bash
eval $(minikube docker-env)
```

#### 6: Now build your Docker image for the Spring Boot application
```bash
docker build -t job-scheduler:latest .
```

#### 7: Deploy CronJobs to Kubernetes
```bash
cd src/main/resources/k8-cron-jobs

kubectl apply -f data-sync-cronjob.yaml

kubectl apply -f notification-cronjob.yaml
```

#### 8: Verify that the CronJobs have been created
```bash
kubectl get cronjobs

```

#### 9: Start the Kubernetes Dashboard
```bash
minikube dashboard

```

#### 10: Open the Kubernetes Dashboard
```bash
http://127.0.0.1:58635/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/

```

![Kubernetes-Dashboard](https://github.com/yusuf-aziz/spring-kubernetes-cronjobs/blob/main/Kubernetes_Dashboard.png?raw=true)


![Kubernetes-Cronjobs](https://github.com/yusuf-aziz/spring-kubernetes-cronjobs/blob/main/Kubernetes_Cronjobs.png?raw=true)


![Kubernetes-Cronjobs-Logs](https://github.com/yusuf-aziz/spring-kubernetes-cronjobs/blob/main/Kubernetes_Cronjobs_logs.png?raw=true)
