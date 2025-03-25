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
            steps whithcredentials([usernamepassword(credentialsId: 'ff1d2baa-e53b-4062-b027-d93be01063f4', variable: 'DOCKERHUB_PASSWORD')]) { 
                echo 'Pushing the image to dockerhub...'
                sh 'docker login -u whydude230 -p $DOCKERHUB_PASSWORD'
                sh 'docker push whydude230/demo_app'
            }
        }
      
    }
}