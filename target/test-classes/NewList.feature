#Author: albertustitang@gmail.com
Feature: Create new List

  Scenario Outline: Add New List (Item combination)
    Given User berada di halaman Main Activity
    When User menekan tombol add
    And User memasukkan title <title>
    And User memasukkan item1 <item1>
    And User memasukkan item2 <item2>
    And User memasukkan item3 <item3>
    And User memasukkan item4 <item4>
    And User memasukkan item5 <item5>
    Then dapat masuk kedalam list

    Examples: 
      | title    | item1 | item2 | item3 | item4   | item5   |
      | Alphabet | makan | minum | mandi | jogging | belajar |
      |        6 |     1 |     2 |     3 |       4 |       5 |
      | $        | !     | @     | ^     | &       | +       |

 
