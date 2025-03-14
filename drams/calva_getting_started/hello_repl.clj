(ns hello-repl)

"Welcome to the Getting Started REPL! 💜"

;; Once you see a message in the output/REPL window ->
;; saying that this file is loaded, you can start by
;; placing the cursor anywhere on line 3 and press
;; `Alt+Enter`. (`Option+Enter` on some machines.)

;; Did it? Great!
;; See that `=> "Welcome ...` at the end of the line?
;; That's the result of the evaluation you just
;; performed. Yes, you just used the Clojure REPL!
;; 🎉 Congratulations! 🎂

(comment
  ;; You can evaluate the below string the same way

  "Hello World!"

  ;; You are in a 'Rich Comment Form' which is where
  ;; we Clojurians most often develop new code.
  ;; https://calva.io/rich-comments/

  ;; Evaluate the following form too, while at it (you can
  ;; place the cursor anywhere on any of the two lines):

  (repeat 7
          "I am using the REPL! 💪")

  ;; Only `=> ("I am using the REPL! 💪"` is displayed
  ;; inline. You can see the full result, and also copy
  ;; it, if you hover the evaluated expression. Or press
  ;; `Ctrl+K Ctrl/Cmd+I`.

  ;; Let's get into the mood for real. 😂
  ;; The cursor on any of the five code lines below:
  ;; `Alt+Enter`, then `Cmd+K Cmd+I`.

  (map (fn [s]
         (if (< (count s) 5)
           (str "Give me " s "! ~•~ " (last s) "!")
           s))
       ["an R" "an E" "a  P" "an L" "What do you get?" "REPL!"])

  ;; Clear the inline display with `Esc`. The inline
  ;; results are also cleared when you edit the file.

  ;; Which brings us to a VERY IMPORTANT THING:
  ;; By default, Calva will be a Guardian of the Parens.
  ;; This means that the backspace and delete buttons
  ;; will not delete balanced brackets. Please go ahead
  ;; try to delete a bracket in the expression above.
  ;; See?

  ;; TO DELETE A BALANCED BRACKET:
  ;;   press `alt/option+backspace` or `alt/option+delete`

  ;; You might notice that the output/REPL window ->
  ;; is also displaying the results. Depending on your
  ;; preferences you might want to close that window or move
  ;; it to the same editor group (unsplit) as the files you
  ;; edit. But don't do that just yet, get a feel how how
  ;; it works having it in a split pane first.

  ;; BTW. That output/REPL window ->
  ;; You can evaluate code from its prompt too.
  ;; But the cool peeps do not do that very often.
  ;; Because the REPL lives in the files with the application
  ;; code! And because Rich Comment Forms (RCF).
  ;; It is Interactive Programming, and it is 💪.
  )



;;
;; = HOW THIS GUIDE WORKS =
;;

;; There are three files for you to explore. For
;; everyone new to Calva:
;; 1. hello_repl.clj (this file)
;; 2. welcome_to_clojure.clj (a Beginner's Clojure Guide)
;; 3. hello_paredit.clj (intro to Calva structural editing)

;; Please don't worry if you don't understand the code 
;; in the this file and in the paredit file.
;; They are short and made so that you can just follow
;; along without the actual code making sense yet. Things
;; will clear up once you have dug into the Clojure Guide.

;; About commands and shortcuts:
;; Please read https://calva.io/finding-commands/
;; (It's very short.)
;; When we refer to commands by their name, use
;; the VS Code Command Palette to search for them
;; if you don't know the keyboard shortcut.
;; All Calva commands are prefixed with ”Calva”.

;; == Evaluating definitions ==
;; Alt+Enter is the Calva default keyboard shortcut
;; to evaluate the current ”top level” forms. Top
;; level meaning the outermost ”container” of forms, 
;; which is the file. This function definition is on
;; the top level. Please evaluate it!

(defn greet
  "I'll greet you"
  [s]
  (str "Hello " s "!"))

;; Forms inside `(comment ...)` are also considered
;; to be top level. This makes it easy to experiment
;; with code.

(comment
  (greet "World"))

;; Anything printed to stdout is not shown inline.

(comment
  (println (greet "World")))

;; You should see the result of the evaluation, nil,
;; inline, and ”Hello World!” followed by the result
;; printed to the output window.

;; Maybe you wonder what a ”form” is? Loosly defined
;; it is about the same as an S-expression:
;; https://en.wikipedia.org/wiki/S-expression
;; That is, either a ”word” or something enclosed in
;; brackets of some type, parens (), hard brackets [],
;; curlies {}, or quotes "". This whole thing is a
;; form:

(str 23 (apply + [2 3]) (:foo {:foo "foo"}))

;; So is `str`, `23`, "foo", `(apply + [2 3])`,
;; `{:foo "foo"}`, `+`, `[2 3]`, `apply`, and also
;; `(:foo {:foo "foo"})`.

;; Calva has a concept of ”current form”, to let you
;; evaluate forms that are not at the top level. The
;; ”current form” is determined by where the cursor is.

;; == Evaluating the Current Form ==
;; Ctrl+Enter evaluates the ”current” form
;; Try it with the cursor at different places in this
;; code snippet:

(comment
  (str 23 (apply + [2 3]) (:foo {:foo "foo"}))

  ;; `foo` is undefined until you top-level eval it.
  (def foo
    [1 2 "three four"])
  )

;; You might discover that Calva regards words in
;; strings as forms. Don't panic if `three` causes
;; an evaluation error. It is not defined, since
;; it shouldn't be. You can define it, of course,
;; just for fun and learning: Top level eval these
;; two definitions.

(comment
  (def three 3)
  (def four "four")
  )

;; Then eval current form inside the string above.
;; Whatever you ask Calva to send to the REPL, Calva
;; will send to the REPL.


;; == Rich Comments Support ==
;; Repeating an important concept: Forms inside
;; `(comment ...)` are also considered top level
;; by Calva. Alt+Enter at different places below
;; to get a feel for it.

(comment
  "I ♥️ Clojure"

  (greet "World")

  foo

  (range 10)

  ;; https://calva.io/rich-comments/
  )


;; Also try the commands *Show Hover*,
;; *Show Definition Preview Hover*
;; *Go to Definition*  

(comment
  (println (greet "side effect"))
  (+ (* 2 2)
     2)

  ;; Here too, if you have Java sources installed
  (Math/abs -1)
  )


;; == You Control what is Evaluated ==
;; Please note that Calva never evaluates your code
;; unless you explicitly ask for it. So, except for
;; this file, you will have to load files you open
;; yourself. Make it a habit to do this, because
;; sometimes things don't work, and they fail in 
;; peculiar ways, when your file is not loaded.

;; Try it with this file: `Ctrl+Alt+C Enter`.
;; The result of loading a file is whatever is the
;; last top level form in the file.

;; == Editing Code ==
;; A note about editing Clojure in Calva:
;; If you edit and experiment with the examples you 
;; will notice that Calva auto-indents your code. 
;; You can re-indent, and format, code at will, using
;; the `Tab` key. It will format the current enclosing
;; form. Try it at the numbered places in this piece
;; of code, starting at `; 1`:

(comment ; 3
     (defn- divisible
           "Is `n` divisible by `d`?"
[n d]
(zero? (mod n d)
           )
       
  )
  
       (defn fizz-buzz [n] ; 2
                       (cond ; 1
(divisible n (* 5 3)) "FizzBuzz"
                      (divisible n 5)       "Buzz"
              (divisible n 3)       "Fizz"
  :else                  n))
                               )

;; === Paredit `strict` mode  is on ===
;; Calva supports structural editing (editing that
;; considers forms rather than lines) using a system
;; called Paredit. By default Paredit tries to protect
;; from accidentally deleting brackets and unbalancing
;; the structure of forms. To override the protection,
;; use `Alt+Backspace` or `Alt+delete`.

(comment
  (defn strict-greet
    "Try to remove brackets and string quotes
   using Backspace or Delete. Try the same
   with the Alt key pressed."
    [name]
    (str "Strictly yours, " name "!"))

  (strict-greet "dear Paredit fan")
  )

;; (Restore with *Undo* if needed.)
;; See `hello_paredit.clj` for more. And also:
;; https://calva.io/paredit

;;;;;;;;;;;;;;;;;;; CHECKPOINT ;;;;;;;;;;;;;;;;;;;

;; You now know enough about Calva to experiment
;; with the code in `welcome_to_clojure.clj`.
;; This file continues with some more neat Calva
;; features, so you should definitely return here
;; when you have learnt some things about Clojure.
;; Like, what a threaded expression is.

;; == Evaluating in Threaded Expressions
;; Ctrl+Alt+Enter will evaluate the current enclosing
;; form up to the cursor. Useful in threaded
;; expressions. Say you want to calculate the average
;; ratings for the data below:

(comment
  ;; First you need to top-level evaluate this
  (def colt-express
    {:name "Colt Express"
     :categories ["Family"
                  "Strategy"]
     :play-time 40
     :ratings {:pez 5.0
               :kat 5.0
               :wiw 5.0
               :vig 3.0
               :rex 5.0
               :lun 4.0}})

  ;; And this
  (defn average [coll]
    (/ (apply + coll) (count coll)))

  ;; This too, if you like
  (->> colt-express
       :ratings
       vals
       average)

  ;; To see the result at each step in the thread
  ;; You can also Ctrl+Alt+Enter after each form.
  ;; Place the cursor after `(->> colt-express` and
  ;; try it. Then after `:ratings`, and after `vals`.
  )

;; == Evaluating Top Level Form to Cursor
;; Shift+Alt+Enter will evaluate all code from
;; the start of the current top level form, up until
;; the cursor, with all open brackets closed.
;; Try it by repeating the above example, but start
;; with placing the cursor at, say, right behind
;; `:wiw 5.0`, then evaluating top level to cursor.

(comment
  ;; The command is useful when evaluating a block of
  ;; code up to a point. You might for instance wrap
  ;; some code in a `(do ...)` and then use the
  ;; *Evaluate From Start of Top Level Form to Cursor*
  ;; command at different places to examine the code.
  ;; Try it at the numbered line comment below.

  ; But first top-level eval this one
  (defn average [coll]
    (/ (apply + coll) (count coll)))

  (do
    (def bar-express
      {:name "Bar Express"
       :categories ["Family"
                    "Strategy"]
       :play-time 40
       :ratings {:pez 5.0
                 :kat 5.0
                 :wiw 5.0   ; 1, then eval `bar-express`
                 :vig 3.0
                 :rex 5.0
                 :lun 4.0}})

    (let [foo-express (-> bar-express
                          (assoc :name "Foo Express")
                          (assoc-in [:ratings :lyr] 5.0)
                          (update-in [:ratings :vig] inc))]
      (->> foo-express   ; 2
           :ratings      ; 3
           vals          ; 4
           (average)     ; 5 (If this blows up you need to
                         ;   top level eval the `average`
                         ;   function definition.)
           )))
  )

;; == The Calva Debugger ==
;; https://calva.io/debugger/
;; The easiest way to use it is to
;; instrument a function for debugging. You do that
;; by having the cursor in the function and then 
;; use the command:
;; *Instrument Current Top Level Form for Debugging*
;; Then you call the function. This will cause the
;; debugger to stop at the first breakable point in
;; the instrumented function

(comment
  ;; Let's try it without instrumentation first. This
  ;; function has a bug. Evaluate it the usual way
  ;; (`Alt+Enter`) first and then call it.

  (defn bar
    [n]
    (cond (> n 40) (+ n 20)
          (> n 20) (- (first n) 20)
          :else 0))

  (bar 2)  ; works
  (bar 24) ; throws, what's going on?

  ;; That's a strange error message (maybe you say,
  ;; depending on how familiar you are with Clojure).
  ;; Now instrument the function as described above.
  ;; Calva will indicate code that is instrumented for
  ;; debugging. Now evaluate the problematic function
  ;; call. The debugger will start and wait for you
  ;; to step through the function.
  ;;
  ;; To un-instrument the function, just evaluate it
  ;; the normal way (top level evaluation).
  ;; Debugger docs here: https://calva.io/debugger/

  ;; NB: If you are new to Clojure you might find some
  ;; familiarity noting that Calva has a debugger.
  ;; However, try exploring Interactive Programming,
  ;; using the REPL first. That's the Clojure Way.
  ;; This section is here for you to get aware that
  ;; the debugger exists, for those rare occasions
  ;; when it is actually needed.
  )

;; == Stopping Infinite Loops ==
;; Since evaluating Clojure expressions is so
;; easy and fun. Sometimes you happen to evaluate
;; something that never finishes, or takes too long
;; to finish. For this, Calva has a command named
;; *Interrupt Running Evaluations*. You will need
;; it if you top-level evaluate this:

(comment
  (def tmp1 (dorun (range)))
  )

;; Done? Awesome. Please consider to familiarize
;; yourself more with Paredit using the interactive
;; guide. If you are new to Clojure, please
;; continue with `welcome_to_clojure.clj`, which is an
;; interactive guide to the Clojure language.

;; Have a Clojure project you want to get hook
;; Calva up to? See: https://calva.io/connect/

;; Learn much more about Calva at https://calva.io 

"hello_repl.clj is loaded, and ready with some things for you to try."

;; This guide downloaded from:
;; https://github.com/BetterThanTomorrow/dram
;; Please consider contributing.
