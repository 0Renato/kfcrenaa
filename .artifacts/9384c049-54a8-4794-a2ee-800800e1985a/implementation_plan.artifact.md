# Plano de Implementação - Correção de Imagens e Estrutura do Projeto

O usuário relatou que as imagens estão incorretas e que a estrutura do projeto não condiz com o estado anterior ("não está igual antes"). A análise revelou que diversos recursos estão usando placeholders genéricos (como `balde2sf`) e que telas importantes (Carrinho e Lista de Cupons) estão ausentes, apesar de existirem ícones e layouts parciais para elas.

## User Review Required

> [!IMPORTANT]
> A estrutura atual parece incompleta. Proponho restaurar a navegação principal para consolidar o projeto.

* **Navegação:** Deseja que a tela principal utilize um `BottomNavigationView` com as abas "Cardápio", "Cupons", "Carrinho" e "Lojas"?
* **Imagens:** Atualmente só temos 3 imagens de produtos/logos (`balde2sf`, `logokfcsf`, `fretesf`). O Sandwich e as Fritas estão usando o logo e um ícone de frete, respectivamente. Devo usar o Balde como placeholder temporário para todos os itens de comida?
* **Fluxo:** O aplicativo deve iniciar na tela de Cadastro ou em uma tela principal de navegação?

## Proposed Changes

### 1. Correção de Recursos e Imagens

#### [MODIFY] [CardapioActivity.java](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/java/com/example/kfcrena/CardapioActivity.java)
* Corrigir o mapeamento de imagens para evitar o uso de ícones de sistema/logos em itens de comida.

#### [MODIFY] [CouponDetailActivity.java](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/java/com/example/kfcrena/CouponDetailActivity.java)
* Garantir que a imagem padrão do cupom faça sentido visualmente.

### 2. Restauração da Estrutura (Telas Faltantes)

#### [NEW] [MainActivity.java](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/java/com/example/kfcrena/MainActivity.java)
* Criar a atividade principal com navegação por abas.

#### [NEW] [CarrinhoActivity.java](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/java/com/example/kfcrena/CarrinhoActivity.java)
* Implementar a tela de checkout usando o `item_carrinho.xml` já existente.

#### [MODIFY] [AndroidManifest.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/AndroidManifest.xml)
* Registrar as novas atividades e configurar a `MainActivity` como ponto de entrada se aprovado.

## Verification Plan

### Automated Tests
* Executar `./gradlew :app:assembleDebug` para garantir que as novas referências de recursos estão corretas.

### Manual Verification
* Implantar no dispositivo e verificar se a navegação entre Cardápio, Cupons e Carrinho está funcionando.
* Validar se as imagens exibidas no Cardápio são consistentes (mesmo que placeholders).
