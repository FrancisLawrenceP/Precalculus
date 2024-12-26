Imports System.Windows.Forms
Imports System.Drawing

Public Class Mangawang
    Public Shared Sub Main()
        Dim frame As New Form() With {
            .Text = "hehe",
            .Size = New Size(400, 200),
            .StartPosition = FormStartPosition.CenterScreen
        }

        Dim panel As New FlowLayoutPanel() With {
            .Dock = DockStyle.Fill
        }

        Dim label As New Label() With {
            .Text = "Sinong shiniship sa bebe ko? - Bianca"
        }

        Dim textField As New TextBox() With {
            .Width = 200
        }

        Dim button As New Button() With {
            .Text = "Attempt to Ship"
        }

        panel.Controls.Add(label)
        panel.Controls.Add(textField)
        panel.Controls.Add(button)
        frame.Controls.Add(panel)

        Dim mePerson As New Person()

        AddHandler button.Click, Sub(sender, e)
                                      Dim otherPerson As String = textField.Text

                                      If otherPerson.Equals("Bianca", StringComparison.OrdinalIgnoreCase) Then
                                          Dim BiancaPoem As Poem = NewTacoPoem()

                                          For i As Integer = 1 To 1000
                                              Application.DoEvents()
                                              Dim poemFrame As New Form() With {
                                                  .Text = "Mwaaaaa mwaaaaa @Rhea Bianca May C. Mangawang, I love youu soo muchh <33",
                                                  .Size = New Size(800, 540)
                                              }

                                              Dim poemArea As New TextBox() With {
                                                  .Multiline = True,
                                                  .ReadOnly = True,
                                                  .Dock = DockStyle.Fill,
                                                  .Text = BiancaPoem.GetPoemText()
                                              }

                                              poemFrame.Controls.Add(New ScrollableControl With {.Dock = DockStyle.Fill, .Controls = {poemArea}})
                                              poemFrame.StartPosition = FormStartPosition.Manual
                                              poemFrame.Location = New Point(CInt(Math.Random() * Screen.PrimaryScreen.Bounds.Width), CInt(Math.Random() * Screen.PrimaryScreen.Bounds.Height))
                                              poemFrame.Show()
                                          Next

                                      ElseIf otherPerson.Equals("Adriaan", StringComparison.OrdinalIgnoreCase) Then
                                          Dim adriaanText As Mockery = MockYourself()

                                          For i As Integer = 1 To 5
                                              Dim adriaanFrame As New Form() With {
                                                  .Text = "Haha wtf are you even doing?!",
                                                  .Size = New Size(500, 100)
                                              }

                                              Dim adriaanArea As New TextBox() With {
                                                  .Multiline = True,
                                                  .ReadOnly = True,
                                                  .Dock = DockStyle.Fill,
                                                  .Text = adriaanText.GetMockeryText()
                                              }

                                              adriaanFrame.Controls.Add(New ScrollableControl With {.Dock = DockStyle.Fill, .Controls = {adriaanArea}})
                                              adriaanFrame.StartPosition = FormStartPosition.Manual
                                              adriaanFrame.Location = New Point(CInt(Math.Random() * Screen.PrimaryScreen.Bounds.Width), CInt(Math.Random() * Screen.PrimaryScreen.Bounds.Height))
                                              adriaanFrame.Show()
                                          Next

                                      Else
                                          Try
                                              mePerson.AttemptToShip(otherPerson)
                                          Catch ex As IsInARelationshipError
                                              Dim stackTrace As String = ex.ToString()

                                              For i As Integer = 1 To 1000
                                                  Application.DoEvents()
                                                  Dim popupFrame As New Form() With {
                                                      .Text = "Bawal na ako iship! @Rhea Bianca Mangawang mii amorr ohhh :<",
                                                      .Size = New Size(700, 400)
                                                  }

                                                  Dim textArea As New TextBox() With {
                                                      .Multiline = True,
                                                      .ReadOnly = True,
                                                      .Dock = DockStyle.Fill,
                                                      .Text = stackTrace
                                                  }

                                                  popupFrame.Controls.Add(New ScrollableControl With {.Dock = DockStyle.Fill, .Controls = {textArea}})
                                                  popupFrame.StartPosition = FormStartPosition.Manual
                                                  popupFrame.Location = New Point(CInt(Math.Random() * Screen.PrimaryScreen.Bounds.Width), CInt(Math.Random() * Screen.PrimaryScreen.Bounds.Height))
                                                  popupFrame.Show()
                                              Next
                                          End Try
                                      End If
                                  End Sub

        frame.ShowDialog()
    End Sub

    Private Shared Function MockYourself() As Mockery
        Return New Mockery("Haha wtf are you even doing to yourself, look!" & vbCrLf &
                           "Don't ship himself to himself!")
    End Function

    Private Shared Function NewTacoPoem() As Poem
        Return New Poem("From endless hours to fleeting seconds," & vbCrLf &
                        "Pain arrived with heavy reckonings." & vbCrLf &
                        "With suffering vast and blood profuse," & vbCrLf &
                        "High hopes shattered, dreams let loose." & vbCrLf & vbCrLf &
                        "But one day came, without a clue," & vbCrLf &
                        "In the depths of darkness I once knew." & vbCrLf &
                        "A light so bright, unseen before," & vbCrLf &
                        "Knocked gently, ready to explore." & vbCrLf & vbCrLf &
                        "From shadows grim and fears untamed," & vbCrLf &
                        "You called me forth, no longer maimed." & vbCrLf &
                        "A shell that bore defeat's harsh sting," & vbCrLf &
                        "You mended, gave it strength to cling." & vbCrLf & vbCrLf &
                        "For all the times you stood so near," & vbCrLf &
                        "A steady presence, calm and clear." & vbCrLf &
                        "Through every trial, you held me tight," & vbCrLf &
                        "A guiding star in my endless night." & vbCrLf & vbCrLf &
                        "And though these words may softly weave," & vbCrLf &
                        "A hidden truth I must now leave:" & vbCrLf &
                        "In every rhyme, a piece of me," & vbCrLf &
                        "A love so pure, it longs to be." & vbCrLf & vbCrLf &
                        "So here I stand, my heart laid bare," & vbCrLf &
                        "With hope and courage, if you care." & vbCrLf &
                        "We could write a story, just us two—" & vbCrLf &
                        "A tale of love that starts with you." & vbCrLf & vbCrLf &
                        "https://open.spotify.com/playlist/2REGe8iSmKI7FRC0HxU4Lk?si=abc433dc55014190&pt=92bf60c0f3e2393eae52347c81440056")
    End Function
End Class

Public Class Person
    Private ReadOnly TakenInARelationship As Boolean = True

    Public Sub AttemptToShip(otherPerson As String)
        If IsTakenInARelationship() Then
            Throw New IsInARelationshipError("private boolean takenInARelationship == true;")
        Else
            MessageBox.Show("Shipping successful with " & otherPerson & "!")
        End If
    End Sub

    Private Function IsTakenInARelationship() As Boolean
        Return TakenInARelationship
    End Function
End Class

Public Class IsInARelationshipError
    Inherits Exception

    Public Sub New(message As String)
        MyBase.New(message)
    End Sub
End Class

Public Class Poem
    Private ReadOnly PoemText As String

    Public Sub New(poemText As String)
        Me.PoemText = poemText
    End Sub

    Public Function GetPoemText() As String
        Return PoemText
    End Function
End Class

Public Class Mockery
    Private ReadOnly MockeryText As String

    Public Sub New(mockeryText As String)
        Me.MockeryText = mockeryText
    End Sub

    Public Function GetMockeryText() As String
        Return MockeryText
    End Function
End Class
