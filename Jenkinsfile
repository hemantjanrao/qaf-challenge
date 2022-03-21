pipeline {
//     agent { docker { image 'maven-chrome:latest' } }
    agent {label "own"}

    stages {
        stage('compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    script {
                        allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                              ])
                    }
                }
            }
        }
    }
}
