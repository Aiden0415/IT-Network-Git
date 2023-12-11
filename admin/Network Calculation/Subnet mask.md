# 서브넷 마스크 구하기

1. 서브넷을 구분할 IP 주소 범위를 정하고 네트워크의 크기를 결정합니다. 서브넷의 크기는 호스트의 개수에 따라 달라집니다.
2. 서브넷의 크기를 이진수로 변환합니다. 즉, 사용 가능한 호스트 수에 해당하는 이진 표현을 찾습니다. 예를 들어, 256개의 호스트를 사용 가능하게 하려면 256을 2진수로 표현하면 100000000이 됩니다.
3. 이진수로 변환한 값을 서브넷 마스크의 32비트 이진수 값에서 사용 가능한 호스트 수만큼 왼쪽으로 채웁니다. 나머지 비트는 모두 0이 됩니다. 위의 예에서 처럼 256개의 호스트를 사용 가능하게 하려면 서브넷 마스크는 11111111.11111111.11111111.00000000이 됩니다.
4. 이진수로 된 서브넷 마스크를 다시 점-10진법으로 변환합니다. 이를 통해 서브넷 마스크 값을 얻을 수 있습니다. 위의 예에서는 255.255.255.0이 됩니다.

간단한 예를 들어보겠습니다:

만약 서브넷에 30개의 호스트를 사용하려면:

1. 30을 2진수로 변환합니다. 30을 2진수로 표현하면 11110이 됩니다.
2. 이진수로 된 서브넷 마스크는 32비트 중에서 30개를 호스트에 사용하므로, 나머지 2개를 네트워크 ID에 사용해야 합니다. 따라서 서브넷 마스크는 11111111.11111111.11111111.11111100이 됩니다.
3. 이를 점-10진법으로 표현하면 255.255.255.252입니다.

이제 주어진 호스트 수에 맞는 서브넷 마스크를 계산하는 방법을 알게 되었습니다. 네트워크 요구 사항에 따라 적절한 서브넷 마스크를 선택하여 네트워크를 효율적으로 분할할 수 있습니다.