# Plano de Implementação - Recuperação da Estrutura Gradle

O projeto não possui os arquivos de configuração do Gradle (`build.gradle`, `settings.gradle`), o que impede o Android Studio de reconhecê-lo como um aplicativo Android. Isso causa o erro no editor de design e a ausência do botão de sincronização.

## User Review Required

> [!CAUTION]
> Vou criar os arquivos fundamentais do Gradle. Após a criação, o Android Studio deverá exibir uma notificação para sincronizar o projeto. Esta etapa é obrigatória para que o editor visual e a compilação voltem a funcionar.

## Proposed Changes

### Configuração do Projeto (Raiz)

#### [NEW] [settings.gradle](file:///Users/senai/AndroidStudioProjects/kfcrenaa/settings.gradle)
* Definir o nome do projeto e incluir o módulo `:app`.

#### [NEW] [build.gradle](file:///Users/senai/AndroidStudioProjects/kfcrenaa/build.gradle)
* Configurar os repositórios (Google, MavenCentral) e a versão do plugin do Android.

#### [NEW] [gradle.properties](file:///Users/senai/AndroidStudioProjects/kfcrenaa/gradle.properties)
* Configurar o uso do AndroidX (necessário para as bibliotecas que usamos).

### Configuração do Módulo App

#### [NEW] [build.gradle](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/build.gradle)
* Definir `applicationId`, `minSdk`, `targetSdk`.
* Adicionar as dependências obrigatórias:
    * `appcompat`
    * `material` (para o tema e botões)
    * `constraintlayout`
    * `recyclerview` (para o cardápio dinâmico)
    * `cardview` (para os cards)

## Verification Plan

### Manual Verification
* Após a criação dos arquivos, verificar se a barra "Gradle files have changed. Sync Now" aparece.
* Clicar em **Sync Now**.
* Abrir qualquer arquivo XML (ex: `activity_cardapio.xml`) e verificar se a aba "Design" está disponível e renderizando corretamente.
