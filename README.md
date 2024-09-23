# Kubernetes CronJobs with Spring Boot

## Overview

In a typical Spring Boot application, scheduled tasks are defined with the `@Scheduled` annotation. However, running multiple instances of the same app in a Kubernetes cluster can lead to duplicate executions. This can waste resources and even cause race conditions. 

In a Spring Boot app, @Scheduled is great for running tasks at fixed intervals. But as we scale, things get messy:
- **Multiple pods**: Each pod runs the same job, which can lead to duplicate work.
- **Heavy tasks**: A big job can slow down the whole app.
- **Scaling issues**: It's hard to manage when and where jobs run.

Using Kubernetes CronJobs and Spring Boot Project, we are able to control all our scheduling in an efficient way. Just pass command-line arguments for indicating which job is supposed to run, and we are good to go! Kubernetes will manage these jobs outside of our app pods, avoiding duplication issues and keeping everything running smoothly.

This project demonstrates how to deploy scheduled tasks in a Kubernetes environment using CronJobs. We are using two scheduled jobs:
1. **Payment Job**: Runs every 5 minutes.
2. **Report Job**: Runs every 10 minutes.

## Try It Out

#### 1: Clone the Repository
```bash
git clone https://github.com/yusuf-aziz/observability-with-micrometer-and-zipkin.git
```

#### 2: Navigate to the cloned repository:
```bash
cd observability-with-micrometer-and-zipkin
```

#### 3: Run mvn clean install:
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

kubectl apply -f payment-cronjob.yaml

kubectl apply -f report-cronjob.yaml
```

#### 8: Verify that the CronJobs have been created
```bash
kubectl get cronjobs

```

#### 9: Open the Kubernetes Dashboard
```bash
minikube dashboard

```






