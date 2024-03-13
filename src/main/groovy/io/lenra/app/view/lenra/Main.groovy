package io.lenra.app.view.lenra;

import static io.lenra.api.components.Components.flex;
import static io.lenra.api.components.Components.view;
import java.util.List;
import io.lenra.api.components.Flex.CrossAxisAlignment;
import io.lenra.api.components.LenraComponent;
import io.lenra.api.components.styles.Direction;
import io.lenra.app.annotation.AppView;

public class Main {
  @AppView(prefix = "lenra.")
  public static LenraComponent main() {
    return flex(List.of(
            view("lenra.menu"),
            view("lenra.home")
            ),
        f -> {
          f.setDirection(Direction.VERTICAL);
          f.setScroll(true);
          f.setSpacing(4d);
          f.setCrossAxisAlignment(CrossAxisAlignment.CENTER);
        }
    );
  }
}
