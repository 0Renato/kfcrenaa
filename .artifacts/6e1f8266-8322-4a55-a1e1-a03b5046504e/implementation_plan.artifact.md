# Plano de Implementação: Correção de Warnings e Otimização

O objetivo deste plano é reduzir drasticamente o número de warnings no projeto, seguindo as melhores práticas do Android (Material 3, acessibilidade e internacionalização).

## Mudanças Propostas

### 1. Recursos de Texto
- [MODIFY] [strings.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/values/strings.xml): Centralizar todos os textos hardcoded do aplicativo (Cadastro, Home, Cardápio, Cupons).

### 2. Layouts (Acessibilidade e Limpeza)
- [MODIFY] [fragment_home.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/fragment_home.xml):
    - Substituir textos hardcoded por `@string`.
    - Adicionar `android:contentDescription` em todas as `ImageView`.
- [MODIFY] [fragment_cupons.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/fragment_cupons.xml): Remover namespace não utilizado (`xmlns:app`).
- [MODIFY] [activity_cadastro.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/activity_cadastro.xml):
    - Substituir textos hardcoded por `@string`.
    - Adicionar `android:contentDescription`.
- [MODIFY] [item_coupon.xml](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/res/layout/item_coupon.xml): Substituir textos hardcoded.

### 3. Código Java (Internacionalização)
- [MODIFY] [HomeFragment.java](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/java/com/example/kfcrena/HomeFragment.java): Usar `getString(R.string...)` em vez de strings literais.
- [MODIFY] [CardapioFragment.java](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/java/com/example/kfcrena/CardapioFragment.java): Usar `getString(R.string...)`.
- [MODIFY] [CuponsFragment.java](file:///Users/senai/AndroidStudioProjects/kfcrenaa/app/src/main/java/com/example/kfcrena/CuponsFragment.java): Usar `getString(R.string...)`.

## Plano de Verificação

### Análise Estática
- Executar `analyze_file` nos arquivos modificados para confirmar a remoção dos warnings.

### Testes Manuais
- Verificar se todos os textos continuam aparecendo corretamente na interface do usuário.
- Confirmar se a navegação e funcionalidade permanecem inalteradas.
