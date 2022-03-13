pipeline {
    agent { docker { image 'maven-chrome:latest' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
