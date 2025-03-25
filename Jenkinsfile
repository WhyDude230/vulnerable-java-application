pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'docker build -t whydude230/demo_app .'
            }
        }
        stage('push') {
            environment {
                DOCKERHUB = credentials("ff1d2baa-e53b-4062-b027-d93be01063f4")
            }
            steps {
                echo 'Pushing the image to dockerhub...'
                sh 'docker login -u whydude230 -p DOCKERHUB_PSW'
                sh 'docker push whydude230/demo_app'
            }
        }
      
    }
}