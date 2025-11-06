import Config

config :distributed_performance_analyzer,
  url: "http://_IP_:8080/api/case-four?latency=10",
  request: %{
    method: "GET",
    headers: [],
    body: ""
  },
  execution: %{
    steps: 25,
    increment: 20,
    duration: 15000,
    constant_load: false,
    dataset: :none,
    separator: ","
  },
  distributed: :none

config :logger,
  level: :warn
