# Análise de Telas Repetidas

Identifiquei que o projeto possui uma implementação redundante para várias funcionalidades, mantendo tanto **Activities** quanto **Fragments** para as mesmas telas.

## Duplicatas Encontradas

| Funcionalidade | Activity (Standalone) | Fragment (Tab Navigation) |
| :--- | :--- | :--- |
| **Carrinho** | `CarrinhoActivity.java` | `CarrinhoFragment.java` |
| **Cardápio** | `CardapioActivity.java` | `CardapioFragment.java` |
| **Lojas** | `RestaurantesActivity.java` | `LojasFragment.java` |

## Causa da Confusão no UI

A principal causa da percepção de "telas repetidas" é a mistura dos dois modelos de navegação:

1.  **MainActivity**: Utiliza um `BottomNavigationView` para alternar entre os Fragments (`CardapioFragment`, `CuponsFragment`, `CarrinhoFragment`, `LojasFragment`).
2.  **CardapioFragment**: No seu cabeçalho (`fragment_cardapio.xml`), existe um botão de carrinho que, ao ser clicado, inicia a `CarrinhoActivity` em vez de apenas trocar para a aba do carrinho na `MainActivity`.

```java
// Em CardapioFragment.java
ImageButton btnCart = view.findViewById(R.id.btnCartHeader);
btnCart.setOnClickListener(v -> {
    Intent intent = new Intent(getActivity(), CarrinhoActivity.class);
    startActivity(intent); // Abre uma NOVA activity por cima
});
```

## Recomendação

Para resolver a duplicidade e inconsistência:
*   Remover as Activities redundantes (`CarrinhoActivity`, `CardapioActivity`, `RestaurantesActivity`).
*   Ajustar a navegação no `CardapioFragment` para que o botão do carrinho selecione a aba correspondente no `BottomNavigationView` da `MainActivity`.
*   Unificar os layouts para evitar manutenção duplicada (ex: `activity_carrinho.xml` e `fragment_carrinho.xml` são quase idênticos).
