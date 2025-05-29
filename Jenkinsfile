pipeline {
    agent any
    environment {
        SEMGREP_APP_TOKEN = credentials('SEMGREP_APP_TOKEN')
    }
    stages {
        stage('Semgrep-Scan') {
                steps {
                sh 'pip3 install semgrep'
                sh 'semgrep ci'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'docker build -t whydude230/demo_app .'
            }
        }
        stage('push') {
            steps {
                echo 'Pushing the image to dockerhub...'
                sh 'docker login -u whydude230 -p 123456789@Test'
                sh 'docker push whydude230/demo_app'
            }
        }
      
    }
}