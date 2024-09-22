pipeline {
    agent any

    stages {
        stage('Run Unit and API Tests') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        // Запуск юнит-тестов
                        sh 'gradle unit_tests'
                    }
                }
                stage('API Tests') {
                    steps {
                        // Запуск API-тестов
                        sh 'gradle api_tests'
                    }
                }
            }
        }
    }

    post {
        always {
            // Публикация отчётов Allure или других тестов (при необходимости)
            junit 'build/test-results/**/*.xml'
        }
    }
}
