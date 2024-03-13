package io.lenra.app.view.lenra

import io.lenra.api.components.Flex
import io.lenra.api.components.Text
import io.lenra.api.components.Button
import io.lenra.api.components.Flex.CrossAxisAlignment
import io.lenra.api.components.Flex.MainAxisAlignment
import io.lenra.api.components.Listener
import io.lenra.app.annotation.AppView


import groovy.transform.CompileStatic

@CompileStatic
class Counter {

  @AppView(prefix = 'lenra.')
  static Flex counter(List<io.lenra.app.data.Counter> counters, Props props) {
    def counter = counters[0]
    new Flex(
      children: [
        new Text(props.text + ': ' + counter.count),
        new Button(
          text: '+',
          onPressed: new Listener('increment', [id: counter.id])
        )
      ],
      spacing: 16d,
      mainAxisAlignment: MainAxisAlignment.SPACE_EVENLY,
      crossAxisAlignment: CrossAxisAlignment.CENTER
    )
  }

  static class Props {

    String text

  }

}
