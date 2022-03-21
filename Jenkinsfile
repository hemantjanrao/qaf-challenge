pipeline {
//     agent { docker { image 'maven-chrome:latest' } }
    agent {label "own"}
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
