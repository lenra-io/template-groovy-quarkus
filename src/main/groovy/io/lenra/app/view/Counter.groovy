package io.lenra.app.view

import io.lenra.api.components.Listener
import io.lenra.app.annotation.AppView

import groovy.transform.CompileStatic

@CompileStatic
class Counter {

  @AppView
  static CounterView counter(List<io.lenra.app.data.Counter> counters) {
    def counter = counters.get(0)
    new CounterView(
      value: counter.count,
      onIncrement: new Listener('increment', [_id: counter.getId()])
    )
  }

  static class CounterView {

    int value
    Listener onIncrement

  }

}
