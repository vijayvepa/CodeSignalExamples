def zig_zag_main():
  grid = [
      [1,2,3,4],
      [5,6,7,8]
    ]
  print( grid)
  traversed =  zig_zag(grid)
  print(traversed)


def zig_zag(grid: list):
  traversed = []	
  rows = len(grid)
  cols = len(grid[0])
  direction = "up"
  size = rows*cols 
  row = rows - 1
  col = cols -1
  
  for i in range(size) :
    traversed.append(grid[row][col])
    row,col = next_location(row, col, direction)	
    direction = next_direction(row, rows, direction)

  return traversed

def next_location(row, col, direction):
  if direction == 'up':
    return row - 1, col
  elif direction == 'down':
    return row + 1, col
  elif direction == 'left':
    return row, col-1
  else:
    return row,col

def next_direction(row, rows, direction):
  if direction == 'up':
    if row == 0:
      return 'left'
    else:
      return direction
  elif direction  == 'down':
    if row == (rows - 1):
      return 'left'
    else:
      return direction
  elif direction == 'left':
    if row == 0:
      return 'down'
    elif row == rows - 1:
      return 'up'
    else:
      return direction
  else:
    return direction
      