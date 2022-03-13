pipeline {
//     agent { docker { image 'maven-chrome:latest' } }
    agent {label "node1"}
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
