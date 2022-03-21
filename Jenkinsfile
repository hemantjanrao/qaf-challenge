pipeline {
//     agent { docker { image 'maven-chrome:latest' } }
    agent {label "own"}

    stages {
        stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
