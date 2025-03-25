pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'docker build -t demo_app .'
            }
        }
        stage('deploy') {
            steps {
                echo 'Running the app...'
                sh 'docker run --rm -p 8000:8000 --name demo_app demo_app'
            }
        }
      
    }
}