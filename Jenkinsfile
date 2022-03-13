pipeline {
//     agent { docker { image 'maven-chrome:latest' } }
    agent {label "master"}
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
