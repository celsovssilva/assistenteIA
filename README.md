🤖 Assistente IA — Gestão Financeira & Multimodalidade com Spring AI📋 Sobre o ProjetoO Assistente IA é uma aplicação backend desenvolvida em Java com Spring Boot e Spring AI, projetada para explorar recursos avançados de Inteligência Artificial Generativa aplicados ao domínio financeiro.O projeto integra múltiplos modelos da OpenAI (Chat, Transcrição de Áudio, Síntese de Voz e Tool Calling) com uma arquitetura desacoplada inspirada em Clean Architecture e Domain-Driven Design (DDD), permitindo que o assistente compreenda comandos em texto ou voz e execute ações reais no sistema, como o registro e a persistência de transações financeiras.✨ Funcionalidades Principais💬 Conversação Inteligente (ChatClient e ChatModel): Endpoints dedicados para interação com modelos de linguagem (LLMs), explorando tanto a API fluente do ChatClient quanto o uso direto do ChatModel.🎙️ Transcrição de Áudio (Speech-to-Text): Conversão de arquivos de áudio em texto utilizando modelos de transcrição da OpenAI (TranscriptionController).🔊 Síntese de Voz (Text-to-Speech): Geração de respostas em áudio a partir de textos (TextToSpeechController).🛠️ Tool Calling (Function Calling): Capacidade do modelo de IA acionar casos de uso da aplicação para registrar transações financeiras automaticamente a partir de linguagem natural.💾 Persistência de Transações: Fluxo completo para criação, categorização e armazenamento de transações financeiras (Transaction, Category, PersisteTransactionUseCase).🏗️ Arquitetura e Estrutura de DiretóriosA organização do código separa as responsabilidades entre regras de negócio, casos de uso, infraestrutura e interfaces de comunicação (Controllers):assistenteIA/
├── gradle/                         # Wrapper do Gradle
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── application/        # Camada de Aplicação (Casos de Uso)
│   │   │   │   ├── input/          # DTOs de entrada (PersistTransactionInput)
│   │   │   │   ├── output/         # DTOs de saída (PersistTransactionOutput)
│   │   │   │   └── PersisteTransactionUseCase.java
│   │   │   ├── domain/             # Camada de Domínio (Entidades, VOs e Contratos)
│   │   │   │   ├── Category.java
│   │   │   │   ├── Transaction.java
│   │   │   │   ├── TransactionId.java
│   │   │   │   └── TransactionRepository.java
│   │   │   ├── infrastrucutre/     # Camada de Infraestrutura (Persistência JPA)
│   │   │   │   └── persistence/
│   │   │   │       ├── entity/     # Entidades de banco (TransactionEntity)
│   │   │   │       └── repository/ # Implementações JPA (JpaTransactionRepository)
│   │   │   ├── ChatClientController.java
│   │   │   ├── ChatModelController.java
│   │   │   ├── TextToSpeechController.java
│   │   │   ├── TranscriptionController.java
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/demo/
│           ├── DemoApplicationTests.java
│           ├── OpeIaSpeechModelIT.java
│           ├── OpenAiChatModelIT.java
│           ├── OpenIaAudioTranscriptionModel.java
│           ├── OpenIaChatClientIT.java
│           └── TooCallingIT.java
├── build.gradle                    # Dependências e configurações do Gradle
├── composer.yml                    # Orquestração de containers (ex.: Banco de Dados)
├── gradlew                         # Executável Gradle (Linux/macOS)
├── gradlew.bat                     # Executável Gradle (Windows)
└── settings.gradle
🚀 Tecnologias UtilizadasLinguagem: JavaFramework Principal: Spring BootInteligência Artificial: Spring AI (integração com OpenAI)Persistência: Spring Data JPAGerenciador de Dependências / Build: GradleInfraestrutura / Containers: Docker & Docker Compose (composer.yml)Testes: JUnit 5 & Spring Boot Test (Testes de Integração *IT)⚙️ Pré-requisitosAntes de iniciar, certifique-se de ter instalado em sua máquina:JDK 17 ou superiorDocker e Docker ComposeUma chave de API válida da OpenAI (OPENAI_API_KEY)🔧 Configuração e Execução1. Clone o repositóriogit clone <url-do-seu-repositorio>
cd assistenteIA
2. Suba os serviços de infraestruturaUtilize o arquivo composer.yml para iniciar os containers necessários (como o banco de dados):docker compose -f composer.yml up -d
3. Configure as variáveis de ambienteDefina sua chave da OpenAI no ambiente ou ajuste o arquivo src/main/resources/application.properties conforme suas credenciais:export OPENAI_API_KEY="sua-chave-api-openai"
(Opcional) Verifique no src/main/resources/application.properties as propriedades de conexão com o banco de dados e configurações dos modelos da OpenAI:spring.ai.openai.api-key=${OPENAI_API_KEY}
# Configurações de datasource conforme definido no composer.yml
4. Execute a aplicaçãoUtilize o Gradle Wrapper para compilar e iniciar o servidor:Linux / macOS:./gradlew bootRun
Windows:gradlew.bat bootRun
A aplicação estará disponível por padrão em http://localhost:8080.🔌 Visão Geral dos ControllersA API expõe endpoints organizados por modalidade de interação com a IA:ControllerResponsabilidadeChatClientControllerInteração conversacional utilizando a abstração de alto nível ChatClient do Spring AI (incluindo suporte a Tool Calling).ChatModelControllerInteração direta com o modelo de chat (ChatModel) para geração de respostas textuais.TranscriptionControllerRecebe arquivos de áudio e retorna a transcrição em texto.TextToSpeechControllerConverte entradas de texto em arquivos de áudio falado.💡 Dica: Consulte as anotações @RequestMapping, @GetMapping e @PostMapping dentro de cada controller em src/main/java/com/example/demo/ para visualizar os caminhos exatos e parâmetros esperados.🧪 Executando os TestesO projeto conta com testes de integração (*IT.java) que validam os fluxos de Chat, Áudio, Síntese de Voz e Tool Calling. Para executá-los (certifique-se de que OPENAI_API_KEY e o Docker estejam ativos):./gradlew test
📄 LicençaEste projeto foi desenvolvido para fins de estudo e demonstração de arquitetura com Spring AI. Sinta-se à vontade para utilizá-lo e adaptá-lo conforme necessário.
