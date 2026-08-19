def winning_team(goals):
    scores = {}

    for team in goals:
        scores[team] = scores.get(team, 0) + 1

    winner = ""
    max_goals = 0

    for team in scores:
        if scores[team] > max_goals:
            max_goals = scores[team]
            winner = team

    return winner


# Input
n = int(input("Enter number of goals: "))

goals = []
for _ in range(n):
    goals.append(input())

print("Winning Team:", winning_team(goals))