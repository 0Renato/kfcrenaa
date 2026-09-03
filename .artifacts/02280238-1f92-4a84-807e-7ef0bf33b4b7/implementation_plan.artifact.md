# Plano de Modernização Visual e Branding KFC

Este plano visa transformar o visual do aplicativo para que ele pareça profissional, moderno e totalmente alinhado à identidade visual do KFC (vermelho vibrante, tipografia arrojada e design limpo).

## User Review Required

> [!IMPORTANT]
> Vou atualizar as cores base para o vermelho oficial do KFC (#E4002B) e adotar o padrão **Material 3**, que oferece componentes mais modernos com cantos arredondados e elevações suaves.

## Proposed Changes

### [Componente: Identidade Visual e Temas]

#### [MODIFY] [colors.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/values/colors.xml)
* Atualizar `kfc_red` para `#E4002B` (Official KFC Red).
* Adicionar variações de cinza neutro para fundos e superfícies.
* Remover cores padrões do Android Studio (purples/teals).

#### [MODIFY] [themes.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/values/themes.xml)
* Migrar para `Theme.Material3.DayNight.NoActionBar`.
* Definir estilos globais para botões (arredondados) e cards.

---

### [Componente: Navegação Principal]

#### [MODIFY] [activity_main.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/activity_main.xml)
* Atualizar o `BottomNavigationView` para o estilo Material 3 (com indicador de aba ativa mais visível).

---

### [Componente: Telas de Lista (Cardápio e Cupons)]

#### [MODIFY] [item_product.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/item_product.xml)
* Modernizar o card: imagem à esquerda com maior destaque, cantos mais arredondados (16dp), e um botão "+" estilizado para adicionar rápido.

#### [MODIFY] [item_coupon.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/item_coupon.xml)
* Design estilo "ticket" com bordas pontilhadas simuladas ou apenas um visual de card mais premium.

#### [MODIFY] [fragment_cardapio.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/fragment_cardapio.xml)
* Adicionar uma barra de categorias horizontal (Chips) no topo (ex: Baldes, Sanduíches, Bebidas).

---

### [Componente: Tela de Detalhes]

#### [MODIFY] [activity_promo_detail.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/activity_promo_detail.xml)
* Criar um efeito de imagem "hero" que ocupa o topo da tela, com o cabeçalho ficando transparente ao rolar.
* Botão de ação fixo na base com um design mais robusto.

---

### [Componente: Carrinho]

#### [MODIFY] [fragment_carrinho.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/fragment_carrinho.xml)
* Melhorar o resumo de valores (Subtotal, Taxas, Total).
* Visual mais limpo para os itens com controles de quantidade (+/-).

## Verification Plan

### Manual Verification
1. Abrir cada tela e comparar com o design atual.
2. Verificar se o vermelho está mais vivo e profissional.
3. Garantir que os botões Material 3 estão com os cantos arredondados corretos.
4. Testar a rolagem na tela de detalhes para ver o efeito do cabeçalho.
