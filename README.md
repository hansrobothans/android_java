<!DOCTYPE html>
<html>
  <head>
    <style>
      pre[data-line] {
        position: relative;
        padding-left: 3.8em;
        counter-reset: linenumber;
      }

      pre[data-line] > code {
        position: relative;
      }

      pre[data-line]:before {
        content: counter(linenumber);
        counter-increment: linenumber;
        position: absolute;
        left: 0;
        top: 0;
        padding-right: 0.8em;
        color: #ccc;
        font-size: 1em;
        font-family: "Courier New", Courier, monospace;
      }
    </style>
  </head>
  <body>
    <pre data-line="1-3"><code>var x = 1;
var y = 2;
var z = x + y;</code></pre>
  </body>
</html>
